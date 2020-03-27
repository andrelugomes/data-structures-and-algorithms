require 'rspec'
require 'data-structures/dynamic_array'

describe DynamicArray do
  
    it 'should set new data into dynamic array' do
        array = DynamicArray.new(1)
        array.set(0,'Hello, world!')

        expect(array.size).to eq 1
        expect(array.get(0)).to eq 'Hello, world!'
    end

    it 'should insert into array' do
        array = DynamicArray.new(1)
        array.set(0,'Hello, world!')
        array.insert(1, 'Hi')

        expect(array.size).to eq 2
        expect(array.get(0)).to eq 'Hello, world!'
        expect(array.get(1)).to eq 'Hi'
    end

    it 'should add to array' do
        array = DynamicArray.new(1)
        array.add 'new'

        expect(array.size).to eq 1
        expect(array.get(0)).to eq 'new'
    end

end