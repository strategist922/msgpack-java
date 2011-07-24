package org.msgpack.template;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.junit.Test;
import org.msgpack.MessagePack;
import org.msgpack.TestSet;
import org.msgpack.packer.BufferPacker;
import org.msgpack.packer.Packer;
import org.msgpack.unpacker.BufferUnpacker;
import org.msgpack.unpacker.Unpacker;


public class TestIntegerArrayTemplate {

    @Test
    public void testStreamPackStreamUnpack00() throws Exception {
	new TestStreamPackStreamUnpack(0).testIntegerArray();
    }

    @Test
    public void testStreamPackStreamUnpack01() throws Exception {
	new TestStreamPackStreamUnpack(1).testIntegerArray();
    }

    @Test
    public void testStreamPackStreamUnpack02() throws Exception {
	new TestStreamPackStreamUnpack(2).testIntegerArray();
    }

    @Test
    public void testStreamPackBufferUnpack00() throws Exception {
	new TestStreamPackBufferUnpack(0).testIntegerArray();
    }

    @Test
    public void testStreamPackBufferUnpack01() throws Exception {
	new TestStreamPackBufferUnpack(1).testIntegerArray();
    }

    @Test
    public void testStreamPackBufferUnpack02() throws Exception {
	new TestStreamPackBufferUnpack(2).testIntegerArray();
    }

    @Test
    public void testBufferPackBufferUnpack00() throws Exception {
	new TestBufferPackBufferUnpack(0).testIntegerArray();
    }

    @Test
    public void testBufferPackBufferUnpack01() throws Exception {
	new TestBufferPackBufferUnpack(1).testIntegerArray();
    }

    @Test
    public void testBufferPackBufferUnpack02() throws Exception {
	new TestBufferPackBufferUnpack(2).testIntegerArray();
    }

    @Test
    public void testBufferPackStreamUnpack00() throws Exception {
	new TestBufferPackStreamUnpack(0).testIntegerArray();
    }

    @Test
    public void testBufferPackStreamUnpack01() throws Exception {
	new TestBufferPackStreamUnpack(1).testIntegerArray();
    }

    @Test
    public void testBufferPackStreamUnpack02() throws Exception {
	new TestBufferPackStreamUnpack(2).testIntegerArray();
    }

    private static class TestStreamPackStreamUnpack extends TestSet {
	private int index;

	TestStreamPackStreamUnpack(int i) {
	    index = i;
	}

	@Test @Override
	public void testIntegerArray() throws Exception {
	    super.testIntegerArray();
	}

	@Override
	public void testIntegerArray(int[] v) throws Exception {
	    MessagePack msgpack = new MessagePack();
	    Template<int[]> tmpl = IntegerArrayTemplate.instance;
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    Packer packer = msgpack.createPacker(out);
	    tmpl.write(packer, v);
	    byte[] bytes = out.toByteArray();
	    Unpacker unpacker = msgpack.createUnpacker(new ByteArrayInputStream(bytes));
	    int[] ret0;
	    switch (index) {
	    case 0:
		ret0 = null;
		break;
	    case 1:
		ret0 = new int[v.length];
		break;
	    case 2:
		ret0 = new int[(int) v.length / 2];
		break;
	    default:
		throw new IllegalArgumentException();
	    }
	    int[] ret = tmpl.read(unpacker, ret0);
	    assertEquals(v.length, ret.length);
	    for (int i = 0; i < v.length; ++i) {
		assertEquals(v[i], ret[i]);
	    }
	}
    }

    private static class TestStreamPackBufferUnpack extends TestSet {
	private int index;

	TestStreamPackBufferUnpack(int i) {
	    index = i;
	}

	@Test @Override
	public void testIntegerArray() throws Exception {
	    super.testIntegerArray();
	}

	@Override
	public void testIntegerArray(int[] v) throws Exception {
	    MessagePack msgpack = new MessagePack();
	    Template<int[]> tmpl = IntegerArrayTemplate.instance;
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    Packer packer = msgpack.createPacker(out);
	    tmpl.write(packer, v);
	    byte[] bytes = out.toByteArray();
	    BufferUnpacker unpacker = msgpack.createBufferUnpacker(bytes);
	    int[] ret0;
	    switch (index) {
	    case 0:
		ret0 = null;
		break;
	    case 1:
		ret0 = new int[v.length];
		break;
	    case 2:
		ret0 = new int[(int) v.length / 2];
		break;
	    default:
		throw new IllegalArgumentException();
	    }
	    int[] ret = tmpl.read(unpacker, ret0);
	    assertEquals(v.length, ret.length);
	    for (int i = 0; i < v.length; ++i) {
		assertEquals(v[i], ret[i]);
	    }
	}
    }

    private static class TestBufferPackBufferUnpack extends TestSet {
	private int index;

	TestBufferPackBufferUnpack(int i) {
	    index = i;
	}

	@Test @Override
	public void testIntegerArray() throws Exception {
	    super.testIntegerArray();
	}

	@Override
	public void testIntegerArray(int[] v) throws Exception {
	    MessagePack msgpack = new MessagePack();
	    Template<int[]> tmpl = IntegerArrayTemplate.instance;
	    BufferPacker packer = msgpack.createBufferPacker();
	    tmpl.write(packer, v);
	    byte[] bytes = packer.toByteArray();
	    BufferUnpacker unpacker = msgpack.createBufferUnpacker(bytes);
	    int[] ret0;
	    switch (index) {
	    case 0:
		ret0 = null;
		break;
	    case 1:
		ret0 = new int[v.length];
		break;
	    case 2:
		ret0 = new int[(int) v.length / 2];
		break;
	    default:
		throw new IllegalArgumentException();
	    }
	    int[] ret = tmpl.read(unpacker, ret0);
	    assertEquals(v.length, ret.length);
	    for (int i = 0; i < v.length; ++i) {
		assertEquals(v[i], ret[i]);
	    }
	}
    }

    private static class TestBufferPackStreamUnpack extends TestSet {
	private int index;

	TestBufferPackStreamUnpack(int i) {
	    index = i;
	}

	@Test @Override
	public void testIntegerArray() throws Exception {
	    super.testIntegerArray();
	}

	@Override
	public void testIntegerArray(int[] v) throws Exception {
	    MessagePack msgpack = new MessagePack();
	    Template<int[]> tmpl = IntegerArrayTemplate.instance;
	    BufferPacker packer = msgpack.createBufferPacker();
	    tmpl.write(packer, v);
	    byte[] bytes = packer.toByteArray();
	    Unpacker unpacker = msgpack.createUnpacker(new ByteArrayInputStream(bytes));
	    int[] ret0;
	    switch (index) {
	    case 0:
		ret0 = null;
		break;
	    case 1:
		ret0 = new int[v.length];
		break;
	    case 2:
		ret0 = new int[(int) v.length / 2];
		break;
	    default:
		throw new IllegalArgumentException();
	    }
	    int[] ret = tmpl.read(unpacker, ret0);
	    assertEquals(v.length, ret.length);
	    for (int i = 0; i < v.length; ++i) {
		assertEquals(v[i], ret[i]);
	    }
	}
    }
}
