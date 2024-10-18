SELECT ID, CASE 
            WHEN lank <= 0.25 THEN "CRITICAL"
            WHEN lank <= 0.5 THEN "HIGH"
            WHEN lank <= 0.75 THEN "MEDIUM"
            WHEN lank <= 1 THEN "LOW"
            end as COLONY_NAME
# SELECT *            
  FROM (SELECT *, PERCENT_RANK() OVER(ORDER BY SIZE_OF_COLONY DESC) as lank
 FROM ECOLI_DATA) AS E1
 ORDER BY ID;