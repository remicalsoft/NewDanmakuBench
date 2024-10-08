﻿#include <math.h>
#include <DxLib.h>
#include "Utils.h"
#include "Define.h"
#include <string>
#include <vector>
#include <time.h>

using namespace std;

/*
*@brief fValの小数点第sN位を四捨五入して丸める
*/
float Utils::roundf(float fVal, int sN) {
	float fAns;
	fAns = fVal * pow(10.f, +sN - 1);
	fAns = (float)(int)(fAns + 0.5f);
	return fAns * pow(10.f, -sN + 1);
}

/*
* @brief -val~valまでの乱数を返す
*/
static int i = 1;
float Utils::randf(float val) {
	int r = GetRand(1000000);
	if(i<630)
	//printfDx("%d:%d\n",i,r);
	i++;
	return r / 500000.f * val - val;
}

bool Utils::isAvailableDevide()
{
	return GetRefreshRate() > 55;;
}
