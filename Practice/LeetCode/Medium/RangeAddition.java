public class YourClassNameHere {
    public static void main(String[] args) {
        int[] result = new int[5];
        int[][] updates = {
            {1,  3,  2},
            {2,  4,  3},
            {0,  2, -2}
        };

        for(int i=0; i<updates.length; i++){
        result[updates[i][0]] += updates[i][2];
        if(updates[i][1]<5-1){
            result[updates[i][1]+1] -=updates[i][2];
        }
    }

     int v=0;
    for(int i=0; i<5; i++){
        v += result[i];
        result[i]=v;
    }

    }

}
----------------------
def getModifiedArray(self, length, updates):

    # Collect the events, i.e., what changes happen and when they happen
    increaseAt = [0] * length
    decreaseAfter = [0] * length
    for start, end, inc in updates:
        increaseAt[start] += inc
        decreaseAfter[end] += inc

    # Sweep, i.e., walk the range, updating the current value and storing it in the output array
    outputArray = [None] * length
    currentValue = 0
    for index in range(0, length):
        currentValue += increaseAt[index]
        outputArray[index] = currentValue
        currentValue -= decreaseAfter[index]

    # Ship it
    return outputArray
