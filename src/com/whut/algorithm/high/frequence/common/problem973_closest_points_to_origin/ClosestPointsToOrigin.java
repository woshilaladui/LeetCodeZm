package com.whut.algorithm.high.frequence.common.problem973_closest_points_to_origin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2021/5/26 11:07
 * @desription
 */
public class ClosestPointsToOrigin {

    class Solution {
        public class Coordinate {
            Integer[] coordinate;
            Integer distance;

            public Coordinate() {
            }

            public Coordinate(Integer[] coordinate, Integer distance) {
                this.coordinate = coordinate;
                this.distance = distance;
            }


        }

        public int[][] kClosest(int[][] points, int k) {

            int[][] result = new int[k][2];

            List<Coordinate> list = new ArrayList<>();

            for (int i = 0; i < points.length; i++) {

                list.add(new Coordinate(
                        new Integer[]{points[i][0], points[i][1]},
                        Math.abs(points[i][0]) * Math.abs(points[i][0]) + Math.abs(points[i][1]) * Math.abs(points[i][1])

                ));
            }

            list.sort(new Comparator<Coordinate>() {
                @Override
                public int compare(Coordinate o1, Coordinate o2) {
                    return o1.distance - o2.distance;
                }
            });

            for (int i = 0; i < k; i++) {
                result[i][0] = list.get(i).coordinate[0];
                result[i][1] = list.get(i).coordinate[1];
            }

            return result;

        }
    }

    public static void main(String[] args) {

    }
}
