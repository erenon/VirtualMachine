package cpu;

import java.util.ArrayList;
import java.util.List;

public class VmStack {
	private List<List<Integer>> frames;
	private int currentFrameIndex;
	
	public VmStack() {
		frames = new ArrayList<List<Integer>>();
		currentFrameIndex = -1;
		
		increaseStackFrame();
	}
	
	public void increaseStackFrame() {
		currentFrameIndex++;
		frames.add(currentFrameIndex, new ArrayList<Integer>());
	}
	
	public void decreaseStackFrame() {
		frames.remove(currentFrameIndex);
		currentFrameIndex--;
	}
	
	public void push(int value) {
		frames.get(currentFrameIndex).add(value);
	}
	
	public int pop() {
		List<Integer> currentFrame = frames.get(currentFrameIndex);
		// get top value
		int topIdx = currentFrame.size() - 1;
		int popped = currentFrame.get(topIdx);
		
		// remove top item
		currentFrame.remove(topIdx);
		
		return popped;
	}
	
	public int getCurrentFrameIndex() {
		return currentFrameIndex;
	}
}
