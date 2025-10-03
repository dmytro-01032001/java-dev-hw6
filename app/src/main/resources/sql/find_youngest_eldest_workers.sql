SELECT 'YOUNGEST' as TYPE, name, birthday
FROM worker WHERE (CURRENT_DATE::date - birthday::date) = (SELECT MIN(CURRENT_DATE::date - birthday::date) from worker)

UNION ALL

SELECT 'OLDEST' as TYPE, name, birthday
FROM worker WHERE (CURRENT_DATE::date - birthday::date) = (SELECT MAX(CURRENT_DATE::date - birthday::date) from worker);

