class LinkedList
  attr_reader :size

  def initialize
    @size = 0
    @head = nil
  end

  def add_front(value)
    new_node = Node.new(value)
    new_node.next = @head unless @head.nil?

    @head = new_node
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
    @head ? @head.data : nil
  end

  def last
    tail = to_tail

    tail ? tail.data : nil
  end

  def delete(value)
    return if @head.nil?

    current = @head

    if value == current.data
      @head = current.next
    else
      while !current.next.nil?
        if value == current.next.data
          current.next = current.next.next
          break
        end
        current = current.next
      end
    end
    decrease_size
  end

  def to_s
    node = @head
    puts node
    while (node = node.next)
      puts node
    end
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

  def decrease_size
    @size -= 1
  end

  class Node
    attr_reader :data
    attr_accessor :next

    def initialize(data)
      @data = data
      @next = nil
    end

    def to_s
      "Node [data: #{@data}]"
    end
  end
end
