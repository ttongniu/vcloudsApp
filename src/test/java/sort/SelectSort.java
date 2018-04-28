package sort;


public class SelectSort implements ISortNumber{
     /**
      * 选择排序
      */
	public int[] sortASC(int[] intArray) {
		if(intArray==null){
			return null;
		}
		int[] srcDatas=intArray.clone();
		int size=srcDatas.length;
		
		for(int i=0 ;i<size;i++){
			
			for(int j=i;j<size;j++){
				if(srcDatas[i]>srcDatas[j]){
					swap(srcDatas, i, j);
				}
			}
			
		}
		
		return srcDatas;
	}
  
	public void  swap(int[] srcData,int src,int dest){	
		int temp=srcData[src];
		srcData[src]=srcData[dest];
		srcData[dest]=temp;
	}
	
}
