<?php

use DataStructures\LinkedList;
use PHPUnit\Framework\TestCase;

class LinkedListTest extends TestCase
{

    function testAddToFront(): void
    {
        $linkedList = new LinkedList();
        $linkedList->addFront("add1");
        $linkedList->addFront("add2");

        self::assertEquals(2, $linkedList->size());
    }

    function testGetHead(): void
    {
        $linkedList = new LinkedList();
        $linkedList->addFront("tail");
        $linkedList->addFront("head");

        self::assertEquals(2, $linkedList->size());
        self::assertEquals("head", $linkedList->getFirst());
    }

    function testGetTailWhenHasNoHead(): void
    {
        $linkedList = new LinkedList();
        $linkedList->addBack("only");

        self::assertEquals(1, $linkedList->size());
        self::assertEquals("only", $linkedList->getLast());
        self::assertEquals("only", $linkedList->getFirst());
    }

    function testGetTail(): void
    {
        $linkedList = new LinkedList();
        $linkedList->addFront("head");
        $linkedList->addBack("tail");

        self::assertEquals(2, $linkedList->size());
        self::assertEquals("tail", $linkedList->getLast());
    }

    function testDeleteByValue(): void
    {
        $linkedList = new LinkedList();
        $linkedList->addFront("add1");
        $linkedList->addFront("add2");
        $linkedList->addFront("add3");
        $linkedList->addFront("add4");

        $linkedList->delete("add1");
        $linkedList->delete("add4");

        self::assertEquals(2, $linkedList->size());
        self::assertEquals("add2", $linkedList->getLast());
        self::assertEquals("add3", $linkedList->getFirst());
    }
}