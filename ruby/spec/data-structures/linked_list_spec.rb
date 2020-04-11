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

    it 'has head' do
      expect(list.first).to eq 'head'
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
