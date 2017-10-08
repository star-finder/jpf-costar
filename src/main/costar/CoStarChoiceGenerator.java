package costar;

import java.util.Comparator;

import gov.nasa.jpf.JPF;
import gov.nasa.jpf.util.JPFLogger;
import gov.nasa.jpf.util.ObjectList.Iterator;
import gov.nasa.jpf.util.ObjectList.TypedIterator;
import gov.nasa.jpf.vm.ChoiceGenerator;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.ThreadInfo;

public class CoStarChoiceGenerator implements ChoiceGenerator<Integer> {

	private JPFLogger logger = JPF.getLogger("costar");
	
	@Override
	public Integer getNextChoice() {
		
		return new Integer(0);
	}

	@Override
	public Class<Integer> getChoiceType() {
		
		return null;
	}

	@Override
	public boolean hasMoreChoices() {
		logger.info("more choices");
		return true;
	}

	@Override
	public void setCurrent() {
		
		
	}

	@Override
	public void advance() {
		
		
	}

	@Override
	public void advance(int nChoices) {
		
		
	}

	@Override
	public void select(int nChoice) {
		
		
	}

	@Override
	public boolean isDone() {
		
		return false;
	}

	@Override
	public void setDone() {
		
		
	}

	@Override
	public boolean isProcessed() {
		
		return false;
	}

	@Override
	public void reset() {
		
		
	}

	@Override
	public int getTotalNumberOfChoices() {
		
		return 0;
	}

	@Override
	public int getProcessedNumberOfChoices() {
		
		return 0;
	}

	@Override
	public Integer getChoice(int i) {
		
		return null;
	}

	@Override
	public Integer[] getAllChoices() {
		
		return null;
	}

	@Override
	public Integer[] getProcessedChoices() {
		
		return null;
	}

	@Override
	public Integer[] getUnprocessedChoices() {
		
		return null;
	}

	@Override
	public ChoiceGenerator<?> getPreviousChoiceGenerator() {
		
		return null;
	}

	@Override
	public int getNumberOfParents() {
		
		return 0;
	}

	@Override
	public ChoiceGenerator<Integer> randomize() {
		
		return null;
	}

	@Override
	public ChoiceGenerator<?> clone() throws CloneNotSupportedException {
		
		return null;
	}

	@Override
	public ChoiceGenerator<?> deepClone() throws CloneNotSupportedException {
		
		return null;
	}

	@Override
	public String getId() {
		
		return null;
	}

	@Override
	public int getIdRef() {
		
		return 0;
	}

	@Override
	public void setIdRef(int idRef) {
		
		
	}

	@Override
	public void setId(String id) {
		
		
	}

	@Override
	public boolean isSchedulingPoint() {
		
		return false;
	}

	@Override
	public void setThreadInfo(ThreadInfo ti) {
		
		
	}

	@Override
	public ThreadInfo getThreadInfo() {
		
		return null;
	}

	@Override
	public void setInsn(Instruction insn) {
		
		
	}

	@Override
	public Instruction getInsn() {
		
		return null;
	}

	@Override
	public void setContext(ThreadInfo tiCreator) {
		
		
	}

	@Override
	public void setStateId(int stateId) {
		
		
	}

	@Override
	public int getStateId() {
		
		return 0;
	}

	@Override
	public String getSourceLocation() {
		
		return null;
	}

	@Override
	public boolean supportsReordering() {
		
		return false;
	}

	@Override
	public ChoiceGenerator<Integer> reorder(Comparator<Integer> comparator) {
		
		return null;
	}

	@Override
	public void setPreviousChoiceGenerator(ChoiceGenerator<?> cg) {
		
		
	}

	@Override
	public void setCascaded() {
		
		
	}

	@Override
	public boolean isCascaded() {
		
		return false;
	}

	@Override
	public <T extends ChoiceGenerator<?>> T getPreviousChoiceGeneratorOfType(Class<T> cls) {
		
		return null;
	}

	@Override
	public ChoiceGenerator<?> getCascadedParent() {
		
		return null;
	}

	@Override
	public ChoiceGenerator<?>[] getCascade() {
		
		return null;
	}

	@Override
	public ChoiceGenerator<?>[] getAll() {
		
		return null;
	}

	@Override
	public <C extends ChoiceGenerator<?>> C[] getAllOfType(Class<C> cgType) {
		
		return null;
	}

	@Override
	public boolean hasAttr() {
		
		return false;
	}

	@Override
	public boolean hasAttr(Class<?> attrType) {
		
		return false;
	}

	@Override
	public Object getAttr() {
		
		return null;
	}

	@Override
	public void setAttr(Object a) {
		
		
	}

	@Override
	public void addAttr(Object a) {
		
		
	}

	@Override
	public void removeAttr(Object a) {
		
		
	}

	@Override
	public void replaceAttr(Object oldAttr, Object newAttr) {
		
		
	}

	@Override
	public <A> A getAttr(Class<A> attrType) {
		
		return null;
	}

	@Override
	public <A> A getNextAttr(Class<A> attrType, Object prev) {
		
		return null;
	}

	@Override
	public Iterator attrIterator() {
		
		return null;
	}

	@Override
	public <A> TypedIterator<A> attrIterator(Class<A> attrType) {
		
		return null;
	}
	
	

}
