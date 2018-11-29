/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.custom.algorithms.struct;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dnikiforov
 */
abstract class BaseTest {
	
	static class XNode extends AbstractNode<Integer, String> {
		
		public XNode(Integer key, String value) {
			super(key, value);
		}
		
	}

	final static AbstractTree<Integer, String> abstractTree = new AbstractTree<Integer, String>() {
			
	};	
}
