package datastructures

type node struct {
	data interface{}
	next *node
}

type LinkedList struct {
	head *node
	size int
}

func (list *LinkedList) New() LinkedList {
	return LinkedList{
		head: nil,
		size: 0,
	}
}

func (list *LinkedList) AddFront(data interface{}) {
	/*newNode := &node{
		data: data,
		next: list.head,
	}

	list.head = newNode*/

	list.head = &node{
		data: data,
		next: list.head,
	}
	list.size++
}

func (list *LinkedList) AddBack(data interface{}) {

	newTail := &node{
		data: data,
		next: nil,
	}
	currentTail := list.tail()

	if currentTail != nil {
		currentTail.next = newTail
	} else {
		list.head = newTail
	}
	list.size++
}

func (list *LinkedList) First() interface{} {
	return list.head.data
}

func (list *LinkedList) Last() interface{} {
	return list.tail().data
}

func (list *LinkedList) tail() *node {
	node := list.head

	for node != nil && node.next != nil {
		node = node.next
	}
	return node
}

func (list *LinkedList) Delete(value interface{}) {
	current := list.head

	//if head
	if value == current.data {
		list.head = current.next
		list.size--
		return
	}
	for current != nil && current.next != nil {
		if value == current.next.data {
			current.next = current.next.next
		}
		current = current.next
	}
	list.size--
}


