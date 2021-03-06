package dist.esper.core.comm.socket;

import dist.esper.core.comm.Link;
import dist.esper.core.id.WorkerId;

/**
 * a virtual link connecting to itself, avoid socket communication.
 * @author tjy
 */
public class LocalLink extends Link{
	public LocalLink(WorkerId myId) {
		super(myId, myId);
	}

	@Override
	public boolean isConnected() {
		return true;
	}

	@Override
	public int send(Object obj) throws RuntimeException {
		this.notifyReceived(obj);
		return LOCAL_TRANSMISSION;
	}

}
