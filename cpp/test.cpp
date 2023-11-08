#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <iostream>
using namespace std;
void Memomry(char **p) { *p = (char *)malloc(100); }

int main() {
    // cout << 123 << endl;
    char *p = NULL;
    Memomry(&p);
    strcpy(p, "hello world");
    printf("%s\n", p);
}
