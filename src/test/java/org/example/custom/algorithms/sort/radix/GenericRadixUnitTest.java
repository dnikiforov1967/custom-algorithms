/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.custom.algorithms.sort.radix;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;
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
public class GenericRadixUnitTest {

    static class StringWrapper extends ByteWrapper<String> {

        public StringWrapper(String obj, int fixedLength) {
            super(obj, fixedLength);
        }

        @Override
        protected byte[] convert() {
            return obj.getBytes();
        }

        @Override
        public String toString() {
            return obj;
        }
        
	@Override
	public int hashCode() {
		int hash = 3;
		hash = 31 * hash + Objects.hashCode(this.obj);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final StringWrapper other = (StringWrapper) obj;
		if (!Objects.equals(this.obj, other.obj)) {
			return false;
		}
		return true;
	}        

    }
    
    static class StringWrapperPadded extends ByteWrapper<String> {

        public StringWrapperPadded(String obj, int fixedLength) {
            super(obj, fixedLength);
        }

        @Override
        protected byte[] convert() {
            final byte[] bytes = obj.getBytes();
            if (obj.length()<fixedLength) {
                byte[] full = new byte[fixedLength];
                int start = fixedLength - bytes.length;
                for(int i=0; i<bytes.length; i++) {
                    full[start + i] = bytes[i];
                }
                return full;
            } else {
                return bytes;
            }
        }

        @Override
        public String toString() {
            return obj;
        }
        
	@Override
	public int hashCode() {
		int hash = 3;
		hash = 31 * hash + Objects.hashCode(this.obj);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final StringWrapperPadded other = (StringWrapperPadded) obj;
		if (!Objects.equals(this.obj, other.obj)) {
			return false;
		}
		return true;
	}        

    }    

    public GenericRadixUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testRadixStringSort() {
        StringWrapper[] array = {
            new StringWrapper("1", 2),
            new StringWrapper("2", 2),
            new StringWrapper("6", 2),
            new StringWrapper("10", 2),
            new StringWrapper("17", 2),
            new StringWrapper("11", 2),
            new StringWrapper("13", 2),
            new StringWrapper("5", 2),};
        
        StringWrapper[] expectedArray = {
            new StringWrapper("1", 2),
            new StringWrapper("10", 2),
            new StringWrapper("11", 2),
            new StringWrapper("13", 2),
            new StringWrapper("17", 2),            
            new StringWrapper("2", 2),
            new StringWrapper("5", 2),
            new StringWrapper("6", 2),
            };        

        GenericRadixSort<StringWrapper> grs = new GenericRadixSort<>();
        array = grs.sort(array, 2);

        assertArrayEquals(expectedArray, array);

    }
    
    @Test
    public void testRadixPaddedStringSort() {
        StringWrapperPadded[] array = {
            new StringWrapperPadded("1", 2),
            new StringWrapperPadded("2", 2),
            new StringWrapperPadded("6", 2),
            new StringWrapperPadded("10", 2),
            new StringWrapperPadded("17", 2),
            new StringWrapperPadded("11", 2),
            new StringWrapperPadded("13", 2),
            new StringWrapperPadded("5", 2),};
        
        StringWrapperPadded[] expectedArray = {
            new StringWrapperPadded("1", 2),          
            new StringWrapperPadded("2", 2),
            new StringWrapperPadded("5", 2),
            new StringWrapperPadded("6", 2),
            new StringWrapperPadded("10", 2),
            new StringWrapperPadded("11", 2),
            new StringWrapperPadded("13", 2),
            new StringWrapperPadded("17", 2),              
            };        

        GenericRadixSort<StringWrapperPadded> grs = new GenericRadixSort<>();
        array = grs.sort(array, 2);

        assertArrayEquals(expectedArray, array);

    }    

}
