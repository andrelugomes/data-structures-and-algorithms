require 'rspec'
require 'data-structures/linked_list'

describe '#new' do
  it 'should create a new list' do
    list = LinkedList.new

    expect(list.size).to eq 0
  end
end

describe '#add_front' do
  context 'when add up front of linkedlist' do
    list = LinkedList.new
    list.add_front('new item')

    it 'has size' do
      expect(list.size).to eq 1
    end

    it 'has head' do
      expect(list.first).to eq 'new item'
    end
  end
end

describe '#first' do
  context 'get the firt node called Head' do
    list = LinkedList.new
    list.add_front('head')
    list.add_front('head2')

    it 'has head' do
      expect(list.first).to eq 'head2'
    end
  end
end

describe '#last' do
  context 'get the last node called Tail' do
    list = LinkedList.new
    list.add_front('first')
    list.add_front('last')

    it 'has tail' do
      expect(list.last).to eq 'first'
    end
  end
end

describe '#add_back' do
  context 'when add back of linkedlist' do
    list = LinkedList.new
    list.add_back('single node')

    it 'has size' do
      expect(list.size).to eq 1
    end

    it 'has head' do
      expect(list.first).to eq 'single node'
    end

    it 'has tail' do
      expect(list.last).to eq 'single node'
    end
  end
end

describe '#delete' do
  context 'when delete head by value' do
    list = LinkedList.new
    list.add_front(1)
    list.add_front(2)
    list.add_front(3)
    list.add_front(4)

    list.delete(4)

    it 'has a new head' do
      expect(list.first).to eq 3
    end
  end
end

describe '#delete' do
  context 'when delete tail node by value' do
    list = LinkedList.new
    list.add_front(1)
    list.add_front(2)
    list.add_front(3)
    list.add_front(4)

    list.delete(1)

    it 'has a new tail' do
      expect(list.last).to eq 2
    end
  end
end

describe '#delete' do
  context 'when delete a middle node by value' do
    list = LinkedList.new
    list.add_front("a")
    list.add_front("b")
    list.add_front("c")
    list.add_front("d")

    list.delete("b")

    it 'has a new tail' do
      expect(list.first).to eq "d"
      expect(list.last).to eq "a"
    end
  end
end
