#include <pthread.h>
#include <stdio.h>

void do_one_thing(int *);
void do_another_thing(int *);
void do_wrap_up(int , int);

int r1, r2 = 0;
int r3 = 0;
pthread_mutex_t r3_mutex = PTHREAD_MUTEX_INITIALIZER;
extern int main(void){
    
    pthread_t t1, t2;
    r3 = 2;
    
    pthread_create(&t1, NULL, do_one_thing, &r1);
    pthread_create(&t2, NULL, do_another_thing, &r2);
    
    pthread_join(t1,NULL);
    pthread_join(t2,NULL);
    
    do_wrap_up(r1, r2);
    return 0;
}
void do_one_thing(int *pnum_times){
    int i, j , x;
    
    pthread_mutex_lock(&r3_mutex);
        if(r3 > 0){
            x = r3;
            r3--;
        }
        else{
            x = 1;
        }
    pthread_mutex_unlock(&r3_mutex);
    for(i =0; i<4 ;i++){
        printf("doing one thing \n");
        for(j =0;j<1000000;j++) x = x + i;
        (*pnum_times)++;
    }
}

void do_another_thing(int *pnum_times){
    int i, j , x;
    pthread_mutex_lock(&r3_mutex);
        if(r3 > 0){
            x = r3;
            r3--;
        }
        else{
            x = 1;
        }
    pthread_mutex_unlock(&r3_mutex);
    for(i =0; i<4 ;i++){
        printf("doing another thing \n");
        for(j =0;j<1000000;j++) x = x + i;
        (*pnum_times)++;
    }
}
void do_wrap_up(int one_times, int another_times)
{
    int total;
    total = one_times + another_times;
    printf("wrap up: one thing %d, another %d, total %d\n",
    one_times, another_times, total);
}
