## distinct
返回唯一不同的值,放在查询语句中的第一个字段前使用，且作用于主句所有列
```sql
mysql> select distinct age from student;
+------+
| age  |
+------+
|   10 |
|   12 |
|   11 |
| NULL |
+------+
4 rows in set (0.01 sec)
```
distinct 多列的去重，则是根据指定的去重的列信息来进行，即只有所有指定的列信息都相同，才会被认为是重复的信息。
```sql
SELECT DISTINCT column1,column2 FROM table_name WHERE where_conditions;
mysql> select distinct sex,age from student;
+--------+------+
| sex    | age  |
+--------+------+
| male   |   10 |
| female |   12 |
| male   |   11 |
| male   | NULL |
| female |   11 |
+--------+------+
5 rows in set (0.02 sec)
```
与 group by 区别：group by可以进行单列去重，group by 的原理是先对结果进行分组排序，然后返回每组中的第一条数据。且是根据 group by 的后接字段进行去重的。
```sql
mysql> select sex,age from student group by sex;
+--------+-----+
| sex    | age |
+--------+-----+
| male   |  10 |
| female |  12 |
+--------+-----+
2 rows in set (0.03 sec)
```

## group by
基础去重
```sql
mysql> select age from student group by age;
+------+
| age  |
+------+
|   10 |
|   12 |
|   11 |
| NULL |
+------+
4 rows in set (0.02 sec)
```
多列去重
```sql
mysql> select sex,age from student group by sex,age;
+--------+------+
| sex    | age  |
+--------+------+
| male   |   10 |
| female |   12 |
| male   |   11 |
| male   | NULL |
| female |   11 |
+--------+------+
5 rows in set (0.03 sec)
```
与 distinct 区别：group by 可以进行单列去重，group by 的原理是先对结果进行分组排序，然后返回每组中的第一条数据。且是根据group by的后接字段进行去重的。
```sql
mysql> select sex,age from student group by sex;
+--------+-----+
| sex    | age |
+--------+-----+
| male   |  10 |
| female |  12 |
+--------+-----+
2 rows in set (0.03 sec)
```