package leiphotos.domain.core;

import java.time.*;

import leiphotos.domain.facade.IPhoto;

public class RecentlyDeletedLibrary extends ATrashLibrary{

	private LocalDateTime lastDeleted;
	private static final int SECONDSTOCLEAN = 20;
	private static final int SECONDSTODELETE = 15;
	
	public RecentlyDeletedLibrary() {
		super();
		lastDeleted = LocalDateTime.now();
		clean();
	}
	
	@Override
	/**
	 * Cleans 
	 */
	protected void clean() {
		if(cleaningTime()) {
			for (IPhoto p : photos) {
				Duration timeInTrash = Duration.between(p.addedDate(), LocalDateTime.now());
				if(timeInTrash.toSeconds() >= SECONDSTODELETE) {
					this.deletePhoto(p);
				}
			}
			lastDeleted = LocalDateTime.now();
		}
	}

	@Override
	protected boolean cleaningTime() {
		LocalDateTime currentTime = LocalDateTime.now();
		Duration timeElapsed = Duration.between(lastDeleted, currentTime);
		
		return timeElapsed.toSeconds() >= SECONDSTOCLEAN;
	}

}
