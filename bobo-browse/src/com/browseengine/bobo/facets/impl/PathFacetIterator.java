/**
 * 
 */
package com.browseengine.bobo.facets.impl;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import com.browseengine.bobo.api.BrowseFacet;
import com.browseengine.bobo.api.FacetIterator;

/**
 * @author nnarkhed
 *
 */
public class PathFacetIterator implements FacetIterator {

	private BrowseFacet[] _facets;
	private int _index;
	
	public PathFacetIterator(List<BrowseFacet> facets) {
		_facets = facets.toArray(new BrowseFacet[facets.size()]);
		_index = -1;
	}
	
	/* (non-Javadoc)
	 * @see com.browseengine.bobo.api.FacetIterator#getFacet()
	 */
	public String getFacet() {
		return _facets[_index].getValue();
	}

	/* (non-Javadoc)
	 * @see com.browseengine.bobo.api.FacetIterator#getFacetCount()
	 */
	public int getFacetCount() {
		return _facets[_index].getHitCount();
	}

	/* (non-Javadoc)
	 * @see com.browseengine.bobo.api.FacetIterator#next()
	 */
	public String next() {
		if((_index >= 0) && !hasNext())
			throw new NoSuchElementException("No more facets in this iteration");
		_index++;
		return _facets[_index].getValue();
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#hasNext()
	 */
	public boolean hasNext() {
		return (_index < (_facets.length-1));
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#remove()
	 */
	public void remove() {
		throw new UnsupportedOperationException("remove() method not supported for Facet Iterators");
	}

}
