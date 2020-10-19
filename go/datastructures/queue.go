package datastructures

type Queue struct {
	head *Node
	tail *Node
	size int
}

func (queue Queue) Size() int {
	return queue.size
}

func (queue Queue) add(value interface{}) {
	node := &Node{
		Data: value,
		Next: nil,
	}

	tail := queue.tail

	if tail != nil {
		tail.Next = node
	}

	if queue.head == nil {
		queue.head = node
	}

	queue.tail = node
	queue.size++
}
func (queue Queue) remove() interface{} {
	head := queue.head

	if head == nil {
		return nil
	}

	queue.head = head.Next

	queue.size--

	return head.Data
}
