<?php

use DataStructures\DynamicArray;
use PHPUnit\Framework\TestCase;

class DynamicArrayTest extends TestCase
{

    public function testSetThenGetByIndex()
    {
        $dynamicArray = new DynamicArray(2);
        $dynamicArray->set(0,'test');
        $dynamicArray->set(1,'test1');

        $this->assertEquals('test', $dynamicArray->get(0));
    }

    public function testInsertIntoArray()
    {
        $dynamicArray = new DynamicArray(1);
        $dynamicArray->insert(0, 'insert');

        $this->assertEquals('insert', $dynamicArray->get(0));
        $this->assertEquals(1, $dynamicArray->size());
    }

    public function testAddIntoArrayAppending()
    {
        $dynamicArray = new DynamicArray(1);
        $dynamicArray->set(0,'first');
        $dynamicArray->add('append');

        $this->assertEquals('append', $dynamicArray->get(1));
        $this->assertEquals(2, $dynamicArray->size());
    }

    public function testDeleteFromArray()
    {
        $array = new DynamicArray(1);
        $array->add('0');
        $array->add('1');
        $array->add('2');

        $array->delete(1);

        $this->assertEquals('0', $array->get(0));
        $this->assertEquals('2', $array->get(1));
        $this->assertEquals(2, $array->size());
    }

    public function testIsEmpty()
    {
        $dynamicArray = new DynamicArray(0);

        $this->assertTrue($dynamicArray->isEmpty());
    }

    public function testContainsData()
    {
        $array = new DynamicArray(1);
        $array->add('this');
        $array->add('that');


        $this->assertTrue($array->contains('that'));
    }
}
