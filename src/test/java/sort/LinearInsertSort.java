package sort;

public class LinearInsertSort  implements ISortNumber {
     /**
      * 线性插入排序
      */
	public int[] sortASC(int[] intArray) {
		if(intArray==null){
			return null;
		}
		int[] srcDatas=intArray.clone();
		int size=srcDatas.length;
		int temp=0;
		int index=0;
		 //假定第一个数字是已经排好了序列，所以i是从1开始而不是从0开始。
		for(int i=1;i<size;i++){
			temp=srcDatas[i];
			index=i;
			while((index>0)&&(temp<srcDatas[index-1])){
				srcDatas[index]=srcDatas[index-1];
				index--;
			}
			srcDatas[index]=temp;
		}
		return srcDatas;
	}
}
