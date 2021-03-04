library(ggplot2)
mtcars

mtcars %>% arrange(wt)

mtcars %>% arrange(desc(wt))

mtcars %>% arrange(gear, wt)

mtcars %>%
  filter(wt>=3 & vs==1) %>% 
  select(-mpg, -cyl) %>% 
  arrange(wt) %>% 
  head(5)

mtcars %>% 
  filter(wt>=3 & vs==1) %>% 
  select(-mpg, -cyl) %>% 
  arrange(desc(wt)) %>% 
  head(5)

mtcars %>% 
  mutate(tnt = disp + wt)

mtcars %>% 
  mutate(tnt = ifelse(disp+wt>=100, "Y", "N"))

mean(mtcars$mpg)

mtcars %>%
  group_by(gear) %>% 
  summarise(mean_mpg = mean(mpg))

mtcars %>% 
  group_by(gear) %>% 
  summarise(n=n(),
            mean_mpg = mean(mpg))

mtcars %>% 
  group_by(gear) %>% 
  summarise(n=n(),
            mpg_mean = mean(mpg),
            mpg_sum = sum(mpg),
            mpg_median = median(mpg))

mtcars %>% 
  group_by(gear) %>% 
  summarise(mpg_mean = mean(mpg),
            mpg_sum = sum(mpg),
            mpg_median = median(mpg)) %>% 
  arrange(mpg_mean)
