public class LVector{

    public final int kMinCapacity = 16;
    public final int kGrowthFactor = 2;
    public final int kShinkFactor = 2;

    private int capacity_ = kMinCapacity;
    private int size_ = 0;
    private int[] data_;


    public LVector(int capacity){
        if (capacity < 1){
            System.out.println("Cannot make vector of that size");
            System.exit(0);
        }

        int trueCapacity = DetermineCapacity(capacity);

        capacity_ = trueCapacity;
        data_ = new int[trueCapacity];
    }

    public int GetSize(){
        return size_;
    }

    public boolean IsEmpty(){
        return size_ == 0;
    }

    public int GetCapacity(){
        return capacity_;
    }


    public void DebugString(){
        System.out.println("size:"+size_);
        System.out.println("capacity:"+capacity_);
        System.out.print("items:");

        for (int i = 0;i<size_;i++){
            System.out.print(data_[i]+",");
        }
    }

    public void Push(int value){
        ResizeForSize(size_ + 1);

        data_[size_] = value;
        ++size_;
    }

    public int Pop(){
        if (size_ == 0){
            System.out.println("Nothing to pop");
            System.exit(0);
        }

        ResizeForSize(size_ - 1);

        int value = data_[size_ - 1];
        --size_;
        return value;
    }

    public int GetValueAt(int index){
        if (index < 0 || index >= size_){
            System.out.println("Index out of bounds.");
            System.exit(0);
        }

        return data_[index];
    }

    public void Insert(int index, int value){
        if (index < 0 || index >= size_){
            System.out.println("Index out of bounds.");
            System.exit(0);
        }

        ResizeForSize(size_ + 1);

        for (int i = size_; i>index; --i){
            data_[i] = data_[i-1];
        }

        data_[index] = value;

        ++size_;
    }

    public void Prepend(int Value){
        Insert(0, 42);
    }

    public void Delete(int index){
        if (index < 0 || index >= size_){
            System.out.println("Index out of bounds.");
            System.exit(0);
        }

        ResizeForSize(size_ - 1);

        for (int i = index; i < size_ - 1; i++) {
            data_[i] = data_[i + 1];
        }

//        data_[size_-1] = 0;

        --size_;
    }

    public void Remove(int value){
        for (int i = 0; i < size_; ++i) {
            if (data_[i] == value) {
                Delete(i);
                --i;  // since items will shift, recheck this index
            }
        }
    }

    public int Find(int value){
        int found_index = -1;

        for (int i = 0; i < size_; ++i) {
            if (data_[i] == value) {
                found_index = i;
                break;
            }
        }

        return found_index;
    }



    private int DetermineCapacity(int capacity){
        int trueCapacity = kMinCapacity;

        while (capacity >= trueCapacity){
            trueCapacity *= kGrowthFactor;
        }

        return trueCapacity;
    }

    private void ResizeForSize(int candidateSize){
        if (size_ < candidateSize) {
            if (size_ == capacity_) {
                IncreaseSize();
            }
        } else if (size_ > candidateSize){
            if (size_ <= capacity_ / kShinkFactor){
                DecreaseSize();
            }
        }
    }

    public void IncreaseSize(){
        int oldCapacity = capacity_;
        int newCapacity = DetermineCapacity(oldCapacity);

        if (oldCapacity != newCapacity){
            int[] newdata = new int[newCapacity];

            for (int i=0; i<size_;++i){
                newdata[i] = data_[i];
            }

            data_ = newdata;
            capacity_ = newCapacity;
        }
    }

    public void DecreaseSize(){
        int oldCapacity = capacity_;
        int newCapacity = oldCapacity/2;

        if (newCapacity < kMinCapacity) {
            newCapacity = kMinCapacity;
        }

        if (oldCapacity != newCapacity){
            int[] newdata = new int[newCapacity];

            for (int i=0; i<size_;++i){
                newdata[i] = data_[i];
            }

            data_ = newdata;
            capacity_ = newCapacity;
        }

    }


}