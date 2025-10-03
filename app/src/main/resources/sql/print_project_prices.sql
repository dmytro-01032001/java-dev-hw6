SELECT p.name, (EXTRACT(YEAR FROM AGE(p.FINISH_DATE, p.START_DATE)) * 12 + 
        EXTRACT(MONTH FROM AGE(p.FINISH_DATE, p.START_DATE))) * SUM(w.salary) as price
FROM project p
JOIN project_worker pw ON p.id = pw.project_id
JOIN worker w ON pw.worker_id = w.id
GROUP BY p.name, p.finish_date, p.start_date
ORDER BY price DESC;
