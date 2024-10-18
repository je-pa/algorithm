-- 코드를 작성해주세요 CONV(15, 10, 2)
SELECT *
FROM    (SELECT CASE
        WHEN categories LIKE '%Front End%' AND names LIKE '%Python%'  THEN 'A'
        WHEN names LIKE '%C#%' THEN 'B'
        WHEN categories LIKE '%Front End%' THEN 'C'
        END AS GRADE,
        ID,
        EMAIL
    FROM
    (
        SELECT 
            ID, 
            MAX(EMAIL) AS EMAIL, 
            GROUP_CONCAT(DISTINCT CATEGORY ORDER BY CATEGORY SEPARATOR ', ') AS categories,
            GROUP_CONCAT(DISTINCT NAME ORDER BY NAME SEPARATOR ', ') AS names
          FROM DEVELOPERS D
          JOIN SKILLCODES S ON (((D.SKILL_CODE/S.CODE)%2) >= 1)
         GROUP BY ID) AS T
     ) AS RESULT
 WHERE GRADE IS NOT NULL
 ORDER BY GRADE, ID
  ;
