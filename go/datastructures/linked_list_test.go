package datastructures

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestLinkedList_New(t *testing.T) {
	//var list LinkedList
	//linkedList := list.New()
	//assert.IsType(t, LinkedList{}, linkedList)

	linkedList := new(LinkedList)
	assert.IsType(t, &LinkedList{}, linkedList)

	assert.Equal(t, 0, linkedList.size)
}

func TestLinkedList_AddFront(t *testing.T)  {
	linkedList := new(LinkedList)
	linkedList.AddFront("add1")
	linkedList.AddFront("add2")
	linkedList.AddFront("add3")

	assert.Equal(t, "add3", linkedList.First())
	assert.Equal(t, "add1", linkedList.Last())
}

func BenchmarkLinkedList_AddFront(b *testing.B)  {
	linkedList := new(LinkedList)

	for i := 0; i < b.N; i++ {
		linkedList.AddFront(i)
	}
}

func BenchmarkLinkedList_AddBack(b *testing.B)  {
	linkedList := new(LinkedList)

	for i := 0; i < b.N; i++ {
		linkedList.AddBack(i)
	}
}

func TestLinkedList_AddBack(t *testing.T)  {
	linkedList := new(LinkedList)
	linkedList.AddBack(1)
	linkedList.AddBack(2)
	linkedList.AddBack(3)

	assert.Equal(t, 1, linkedList.First())
	assert.Equal(t, 3, linkedList.Last())
}

func TestLinkedList_Delete(t *testing.T)  {
	linkedList := new(LinkedList)
	linkedList.AddFront(1)
	linkedList.AddBack(2)
	linkedList.AddBack(3)

	linkedList.Delete(2)

	assert.Equal(t, 1, linkedList.First())
	assert.Equal(t, 3, linkedList.Last())
}

func TestLinkedList_DeleteHead(t *testing.T)  {
	linkedList := new(LinkedList)
	linkedList.AddFront(1)
	linkedList.AddBack(2)
	linkedList.AddBack(3)

	linkedList.Delete(1)

	assert.Equal(t, 2, linkedList.First())
	assert.Equal(t, 3, linkedList.Last())
}

func TestLinkedList_DeleteOnlyOneNode(t *testing.T)  {
	linkedList := new(LinkedList)
	linkedList.AddFront(1)

	linkedList.Delete(1)

	assert.Equal(t, 0, linkedList.size)
}

func TestLinkedList_DeleteTail(t *testing.T)  {
	linkedList := new(LinkedList)
	linkedList.AddFront(1)
	linkedList.AddBack(2)
	linkedList.AddBack(3)

	linkedList.Delete(3)

	assert.Equal(t, 1, linkedList.First())
	assert.Equal(t, 2, linkedList.Last())
}
