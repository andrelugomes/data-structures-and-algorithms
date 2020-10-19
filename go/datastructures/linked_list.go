package datastructures

type LinkedList struct {
	head *Node
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

	list.head = &Node{
		Data: data,
		Next: list.head,
	}
	list.size++
}

func (list *LinkedList) AddBack(data interface{}) {

	newTail := &Node{
		Data: data,
		Next: nil,
	}
	currentTail := list.tail()

	if currentTail != nil {
		currentTail.Next = newTail
	} else {
		list.head = newTail
	}
	list.size++
}

func (list *LinkedList) First() interface{} {
	return list.head.Data
}

func (list *LinkedList) Last() interface{} {
	return list.tail().Data
}

func (list *LinkedList) tail() *Node {
	node := list.head

	for node != nil && node.Next != nil {
		node = node.Next
	}
	return node
}

func (list *LinkedList) Delete(value interface{}) {
	current := list.head

	//if head
	if value == current.Data {
		list.head = current.Next
		list.size--
		return
	}
	for current != nil && current.Next != nil {
		if value == current.Next.Data {
			current.Next = current.Next.Next
		}
		current = current.Next
	}
	list.size--
}


