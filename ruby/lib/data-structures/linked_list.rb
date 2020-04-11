class LinkedList
  attr_reader :size

  def initialize
    @size = 0
    @head = nil
  end

  def add_front(value)
    new_node = Node.new(value)
    if @head.nil?
      @head = new_node
    else
      new_node.next = @head
    end

    increase_size
  end

  def add_back(value)
    node = Node.new(value)

    if @head.nil?
      @head = node
      increase_size
      return
    end

    tail = to_tail

    if tail.nil?
      @head.next = node
    else
      tail.next = node
    end
    increase_size
  end

  def first
    @head.data
  end

  def last
    tail = to_tail

    tail.data
  end

  private

  def to_tail
    current = @head
    current = current.next until current.next.nil?
    current
  end

  def increase_size
    @size += 1
  end

  class Node
    attr_reader :data
    attr_accessor :next

    def initialize(data)
      @data = data
      @next = nil
    end
  end
end
