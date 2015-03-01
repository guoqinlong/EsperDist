package dist.esper.core.flow.container;

import java.io.Serializable;


import dist.esper.core.cost.DeltaResourceUsage;
import dist.esper.core.flow.stream.RootStream;

/**
 * the execution instance plan generated by @StreamContainerTreeBuilder.
 * its based on the execution plan @StreamFlow for single epl.
 * @author tjy
 *
 */
public class StreamContainerFlow implements Serializable {
	private static final long serialVersionUID = 8646708927682076933L;
	long eplId;
	String epl;
	RootStream rootStream=null;
	RootStreamContainer rootContainer=null;
	transient DeltaResourceUsage rootDeltaResourceUsage=null;

	public StreamContainerFlow() {
		super();		
	}

	public StreamContainerFlow(long eplId, String epl, RootStream rootLocation, 
			RootStreamContainer rootContainer, DeltaResourceUsage rootDeltaResourceUsage) {
		super();
		this.eplId = eplId;
		this.epl = epl;
		this.rootStream = rootLocation;
		this.rootContainer = rootContainer;
		this.rootDeltaResourceUsage = rootDeltaResourceUsage;
	}
	
	@Override
	public String toString(){
		StringBuilder sw=new StringBuilder();
		sw.append(epl);
		sw.append('\n');
		rootStream.toStringBuilder(sw, 0);
		sw.append('\n');
		rootContainer.toStringBuilder(sw, 0);
		return sw.toString();//FIXME
	}

	public long getEplId() {
		return eplId;
	}

	public void setEplId(long eplId) {
		this.eplId = eplId;
	}	

	public String getEpl() {
		return epl;
	}

	public void setEpl(String epl) {
		this.epl = epl;
	}

	public RootStream getRootStream() {
		return rootStream;
	}

	public void setRootStream(RootStream rootLocation) {
		this.rootStream = rootLocation;
	}

	public RootStreamContainer getRootContainer() {
		return rootContainer;
	}

	public void setRootContainer(RootStreamContainer root) {
		this.rootContainer = root;
	}

	public DeltaResourceUsage getRootDeltaResourceUsage() {
		return rootDeltaResourceUsage;
	}

	public void setRootDeltaResourceUsage(DeltaResourceUsage rootDeltaResourceUsage) {
		this.rootDeltaResourceUsage = rootDeltaResourceUsage;
	}
}
