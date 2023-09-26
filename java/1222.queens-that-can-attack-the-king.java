
/*
 * @lc app=leetcode.cn id=1222 lang=java
 * 
 * @lcpr version=21913
 *
 * [1222] 可以攻击国王的皇后
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;
import java.util.ArrayDeque;
// @lc code=start

class Solution {
	public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
		Set<Integer> queenPos = new HashSet<>();
		for (int[] q : queens) {
			int x = q[0], y = q[1];
			// 给出一个Hash函数将queen的坐标存进去HashSet
			queenPos.add(x * 8 + y);
		}
		List<List<Integer>> ans = new ArrayList<>();
		for (int dx = -1; dx <= 1; dx++) {
			for (int dy = -1; dy <= 1; ++dy) {
				if (dx == 0 && dy == 0) {
					continue;

				}
				int kx = king[0] + dx, ky = king[1] + dy;
				while (kx >= 0 && kx < 8 && ky >= 0 && ky < 8) {
					int pos = kx * 8 + ky;
					if (queenPos.contains(pos)) {
						List<Integer> posList = new ArrayList<Integer>();
						posList.add(kx);
						posList.add(ky);
						ans.add(posList);
						break;
					}
					kx += dx;
					ky += dy;
				}
			}
		}
		return ans;
	}
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]]\n[0,0]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[0,0],[1,1],[2,2],[3,4],[3,5],[4,4],[4,5]]\n[3,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * //
 * [[5,6],[7,7],[2,1],[0,7],[1,6],[5,1],[3,7],[0,3],[4,0],[1,2],[6,3],[5,0],[0,4
 * ],[2,2],[1,1],[6,4],[5,4],[0,0],[2,6],[4,5],[5,2],[1,4],[7,5],[2,3],[0,5],[4,
 * 2],[1,0],[2,7],[0,1],[4,6],[6,1],[0,6],[4,3],[1,7]]\n[3,4]\n
 * // @lcpr case=end
 * 
 */
