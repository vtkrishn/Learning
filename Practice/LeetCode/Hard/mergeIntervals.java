public List<Interval> merge(List<Interval> intervals) {
	// sort start&end
	int n = intervals.size();
	int[] starts = new int[n];
	int[] ends = new int[n];
	for (int i = 0; i < n; i++) {
		starts[i] = intervals.get(i).start;
		ends[i] = intervals.get(i).end;
	}
	Arrays.sort(starts);
	Arrays.sort(ends);
	// loop through
	List<Interval> res = new ArrayList<Interval>();
	for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
		if (i == n - 1 || starts[i + 1] > ends[i]) {
			res.add(new Interval(starts[j], ends[i]));
			j = i + 1;
		}
	}
	return res;
}
