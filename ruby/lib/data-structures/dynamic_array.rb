class DynamicArray

    def initialize(initial_capacity)
        @initial_capacity = initial_capacity
        @size = 0
        #data = [] #Dynamic by nature
        @data = Array.new(initial_capacity) #here too, but... let's try
    end

    def set(index, value)
        @data[index] = value
        increase_size
    end

    def get(index)
        @data[index]
    end

    def size
        @size
    end

    def insert(index, value)
        resize?
        
        #shift up
        (@size + 1).downto(index).each { |i|
            @data[i] = @data[i - 1]
        }

        @data[index] = value
        increase_size
    end

    def add(value)
        resize?

        @data[@size] = value

        increase_size
    end

    def delete(index)
        #shift down
        for i in index..(@size - 1)
            @data[i] = @data[i + 1]
        end

        #clear last
        if index == @size then
            @data[index] = nil
        else
            @data[@size - 1] = nil
        end

        decrease_size
    end

    def contains(value)
        #@data.include? value
        @data.each { |data|
            if data == value then return true 
            end
        }
        return false
    end
    
    private
    def resize?
        if @size == @initial_capacity then resize end
    end

    def resize
        new_capacity = @initial_capacity * 2
        new_data = Array.new new_capacity
        new_data = @data.dup
        @data = new_data
    end

    def increase_size
        @size=@size+1
    end

    def decrease_size
        @size=@size-1
    end


end