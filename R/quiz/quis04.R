library(ggplot2)

mtcars

mtcars %>% filter(vs==1)

mtcars %>% filter(vs!=1)

mtcars %>% filter(wt>3 & vs==1)

mtcars %>% filter(carb==2 | vs==1)

mtcars %>% filter(carb %in% c(1,2,3))

mtcars %>% select(mpg, cyl)

mtcars %>% select(-mpg, -cyl)

mtcars %>%
  filter(wt>=3 & vs==1) %>% 
  select(-mpg, -cyl)
mtcars %>% 
  select(mpg, cyl) %>% 
  head(5)

mtcars %>% 
  filter(wt>=3 & vs==1) %>% 
  select(-mpg, -cyl) %>% 
  head(5)
