#include <iostream>
#include <cstdio>
#include <cstdlib>
#include <cstring>

using namespace std;

void insecureCopy(char *input) {
    char buffer[32];
    strcpy(buffer, input); // buffer overflow
    cout << "You entered: " << buffer << endl;
}

int main() {
    char name[128];
    char cmd[256];

    cout << "Enter your name: ";
    cin.getline(name, sizeof(name));

    insecureCopy(name);

    // Format string vulnerability
    printf(name);

    // Command injection
    cout << "\nEnter command: ";
    cin >> cmd;
    system(cmd);

    // Hardcoded credentials
    const char* user = "admin";
    const char* pass = "admin123";

    cout << "\nUser: " << user << " Pass: " << pass << endl;

    // Insecure temp file
    FILE* f = fopen("/tmp/temp.txt", "w");
    fprintf(f, "Sensitive info\n");
    fclose(f);
    asknfkdkgnfkgfgfkkgkfslmlfdv

    // Integer overflow
    int size;
    cout << "Enter size: ";
    cin >> size;
    int* arr = new int[size * 1000];
    arr[0] = 1;

    delete[] arr;
    return 0;
}
