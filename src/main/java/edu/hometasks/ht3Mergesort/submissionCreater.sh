#!/usr/bin/env bash
rm -fr submission/*
cp BruteCollinearPoints.java submission
tail -n +2 submission/BruteCollinearPoints.java > submission/BruteCollinearPoints.java.tmp && mv submission/BruteCollinearPoints.java.tmp submission/BruteCollinearPoints.java

cp FastCollinearPoints.java submission
tail -n +2 submission/FastCollinearPoints.java > submission/FastCollinearPoints.java.tmp && mv submission/FastCollinearPoints.java.tmp submission/FastCollinearPoints.java

cp Point.java submission
tail -n +2 submission/Point.java > submission/Point.java.tmp && mv submission/Point.java.tmp submission/Point.java

cd submission
zip collinear.zip *