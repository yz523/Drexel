--This is for question a
select distinct Dishes.dish
from Dishes, Foods
where Dishes.food = Foods.food
and Foods.category = 'meat'
and Dishes.dish in (select distinct Dishes.dish
				   from Dishes, Foods
				   where Dishes.food = Foods.food
				   and Foods.category = 'veg')
order by Dishes.dish;

-- This is for question b
select Foods.category
from Foods, Dishes
where Foods.category not in (select Foods.category
							from Dishes, Foods
							where Dishes.food = Foods.food);

-- This is for question c
select Dishes.dish, count(*) as num_ingredients
from Dishes, Foods
where Dishes.food = Foods.food
group by Dishes.dish;

-- This is for question d
select Dishes.dish, count(*) as num_ingredients, sum(calories) as total_calories
from Dishes, Foods
where Dishes.food = Foods.food
group by Dishes.dish
having sum(calories) < 250;

-- This is for question e
select Dishes.dish, sum(calories) as total_calories
from Dishes, Foods
where Dishes.food = Foods.food
group by Dishes.dish
having count(*) = 3;