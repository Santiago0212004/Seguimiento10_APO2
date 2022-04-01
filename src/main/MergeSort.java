package main;

import java.util.ArrayList;

public class MergeSort {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		
		arr.add(8);
		arr.add(12);
		arr.add(5);
		arr.add(6);
		arr.add(-1);
		arr.add(3);
		arr.add(7);
		arr.add(10);
		
		ArrayList<Integer> sortedArr =  mergeSort(arr);
		
		System.out.println(sortedArr);
		
		/*
		ArrayList<Integer> A = new ArrayList<>();
		A.add(1);
		A.add(4);
		A.add(8);
		A.add(10);
		
		ArrayList<Integer> B = new ArrayList<>();
		B.add(2);
		B.add(3);
		B.add(4);
		
		System.out.println(merge(A,B));*/
	}
	
	public static ArrayList<Integer> mergeSort(ArrayList<Integer> arr, int beg, int end){
		
		if(beg==end) {
			ArrayList<Integer> base = new ArrayList<>();
			base.add(arr.get(beg));
			return base;
		}
		
		int mid = (beg + end)/2;
		
		ArrayList<Integer> left = mergeSort(arr, beg, mid);
		ArrayList<Integer> right = mergeSort(arr, mid+1, end);
		ArrayList<Integer> total = merge(left,right);
		
		return total;
	}

	public static ArrayList<Integer> mergeSort(ArrayList<Integer> arr){

		return mergeSort(arr,0,arr.size()-1);
		
	}
	
	public static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right){
		ArrayList<Integer> res = new ArrayList<>();
		
		int i = 0;
		int j = 0;
		
		while(i<left.size() && j<right.size()) {
			if(left.get(i) < right.get(j)) {
				res.add(left.get(i));
				i++;
			} else {
				res.add(right.get(j));
				j++;
			}
		}
		
		while(i<left.size()) {
			res.add(left.get(i));
			i++;
		}
		
		while(j<right.size()) {
			res.add(right.get(j));
			j++;
		}
		
		return res;
	}
	
}
