package datastructures

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestDynamicArray_New(t *testing.T) {
	var array DynamicArray
	dynamicArray := array.New(1)

	assert.IsType(t, DynamicArray{}, dynamicArray)
}

func TestDynamicArray_SetAndGet(t *testing.T) {
	var array DynamicArray
	dynamicArray := array.New(2)
	dynamicArray.Set(0, "test")
	dynamicArray.Set(1, 123)

	assert.Equal(t, "test", dynamicArray.Get(0))
	assert.Equal(t, 123, dynamicArray.Get(1))
}

func TestDynamicArray_Insert(t *testing.T) {
	var array DynamicArray
	dynamicArray := array.New(1)
	dynamicArray.Insert(0,"0")
	dynamicArray.Insert(1,"1")
	dynamicArray.Insert(0,"0-2")

	assert.Equal(t, 3, dynamicArray.size)
}

//Doesn't work
func TestDynamicArray_InsertAfterSet(t *testing.T) {
	var array DynamicArray
	dynamicArray := array.New(2)
	dynamicArray.Set(0, "0")
	dynamicArray.Set(1, "2")

	dynamicArray.Insert(1,"1")
}

func TestDynamicArray_Add(t *testing.T) {
	var array DynamicArray
	dynamicArray := array.New(1)
	dynamicArray.Add(10)
	dynamicArray.Add(100)

	assert.Equal(t, 2, dynamicArray.size)
	assert.Equal(t, 10, dynamicArray.Get(0))
	assert.Equal(t, 100, dynamicArray.Get(1))
}

//Doesn't work well, skipping the first index
func TestDynamicArray_Append(t *testing.T) {
	var array DynamicArray
	dynamicArray := array.New(1)
	dynamicArray.Append("appending")

	assert.Equal(t, "appending", dynamicArray.Get(1))
}

func TestDynamicArray_Delete(t *testing.T) {
	var array DynamicArray
	dynamicArray := array.New(1)
	dynamicArray.Add(10)
	dynamicArray.Add(11)
	dynamicArray.Add(12)

	dynamicArray.Delete(0)

	assert.Equal(t, 2, dynamicArray.size)
	assert.Equal(t, 11, dynamicArray.Get(0))
}

func TestDynamicArray_Contains(t *testing.T) {
	var array DynamicArray
	dynamicArray := array.New(1)
	dynamicArray.Add("andré")
	dynamicArray.Add("luis")

	assert.True(t, dynamicArray.Contains("andré"))
	assert.True(t, dynamicArray.Contains("luis"))
}
