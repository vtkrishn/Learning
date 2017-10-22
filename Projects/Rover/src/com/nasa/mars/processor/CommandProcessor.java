package com.nasa.mars.processor;

public interface CommandProcessor {

	void processInstructionSets(String instructionSets);
	void processLEFT();
	void processRIGHT();
	void processMOVE();
	
}
