package datastructures

type DynamicArray struct {
	size int
	initialCapacity int
	data []interface{}
}

func (da *DynamicArray) New(initialCapacity int) DynamicArray {
	return DynamicArray{size: 0, initialCapacity: initialCapacity, data: make([]interface{}, initialCapacity)}
}

func (da *DynamicArray) Get(index int) interface{} {
	return da.data[index]
}

func (da *DynamicArray) Set(index int, data interface{}) {
	da.data[index] = data
	da.size++
}

func (da *DynamicArray) Insert(index int, value interface{})  {
	// Check size
	if da.size == da.initialCapacity {
		resize(da)
	}

	// Copy up | Shift
	for j := da.size; j > index; j-- {
	    da.data[j] = da.data[j - 1]
	}

	// Insert
	da.data[index] = value
	da.size++
}

//Add is like a Append
func (da *DynamicArray) Add(value interface{})  {
	// Check size
	if da.size == da.initialCapacity {
		resize(da)
	}

	// Insert
	da.data[da.size] = value
	da.size++
}

//Slice appending
func (da *DynamicArray) Append(value interface{})  {
	da.data = append(da.data, value)
}

func (da *DynamicArray) Delete(index int) {
	// Copy down
	for  j := index; j < da.size - 1; j++ {
		da.data[j] = da.data[j + 1]
	}

	// Clear if last element in array
	if index == da.size {
		da.data[index] = nil
	}else {
		//Clear last value index
		da.data[da.size - 1] = nil
	}

	da.size--
}

func (da *DynamicArray) Contains(value interface{}) bool{
	for i := 0; i < da.size; i++ {
		if da.data[i] == value {
			return true
		}
	}
	return false
}

func (da DynamicArray) Empty() bool {
	return da.size == 0
}

func resize(da *DynamicArray) {
	newCapacity := da.initialCapacity * 2
	newData := make([]interface{}, newCapacity)

	if da.initialCapacity > 0 {
		copy(newData, da.data)
	}
	da.data = newData
	da.initialCapacity = newCapacity
}
