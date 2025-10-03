SELECT c.id, c.name, COUNT(p.client_id) as PROJECT_COUNT FROM client c
JOIN project p ON c.id = p.client_id
GROUP BY c.id
HAVING COUNT(p.client_id) = (
    SELECT MAX(cnt)
    FROM (
        SELECT COUNT(*) AS cnt
        FROM project
        GROUP BY client_id
    ) t
);
