package org.encog.ml.prg.extension;

import java.util.Random;

import org.encog.ml.prg.ProgramNode;

public abstract class BasicTemplate implements ProgramExtensionTemplate {

	private final String name;
	private final int childNodeCount;
	private final boolean varValue;
	private final int dataSize;
	private final NodeType nodeType;
	private final int precedence;

	public BasicTemplate(final int thePrecedence, 
			final String theName, final NodeType theType, final boolean isVariable, 
			final int theDataSize, final int childCount) {
		this.precedence = thePrecedence;
		this.name = theName;
		this.childNodeCount = childCount;
		this.varValue = isVariable;
		this.dataSize = theDataSize;
		this.nodeType = theType;
	}
	
	public BasicTemplate(
			final String theName, final int childCount) {
		this(0,theName,NodeType.Function,false,0,childCount);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getChildNodeCount() {
		return this.childNodeCount;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public boolean isVariable() {
		return this.varValue;
	}
	
	@Override
	public int getDataSize() {
		return this.dataSize;
	}
	
	/**
	 * @return the nodeType
	 */
	@Override
	public NodeType getNodeType() {
		return nodeType;
	}
	
	@Override
	public int getPrecedence() {
		return this.precedence;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("[BasicTemplate:");
		result.append(name);
		result.append(",type=");
		result.append(this.nodeType.toString());
		result.append("argCount=");
		result.append(this.childNodeCount);
		result.append("]");
		return result.toString();
	}

	@Override
	public void randomize(final Random rnd, final ProgramNode actual, final double minValue, final double maxValue) {

	}
}
