package coen352.ch4.stack;

import coen352.ch4.list.Link;

/**
 * All of the code written under coen352.ch4.stack was give to us on moodle
 */

public class LStack<E> implements ADTStack<E> {
	
	private Link<E> top;
	int size;
	
	public LStack() {
		init();
	}
	
	private void init() {
		top = new Link<E>(null);
		size = 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void push(E it) {
		top.setNext(new Link<E>(it, top.next()));
		++size;
	}

	@Override
	public E pop() {
		if(top.next()!=null) {
			Link<E> temp = top.next();
			top = top.next();
			--size;
			return temp.element();
			
		}
		return null;
	}

	@Override
	public E topValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return size;
	}
	
	public String toString()
	{
		StringBuffer out = new StringBuffer((length() + 1) * 4);
		out.append("< ");
		for (Link<E> i = top.next(); i != null; i = i.next()) {
		  out.append(i.element());
		  out.append(" ");
		}
		out.append(">");
		return out.toString();
	}

}
