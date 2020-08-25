using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cart_rider
{
    class Cart//출발 부스터, 팀부스터, 부스터, 드리프트, 순간부스터
    {
        int Speed = 0;//속도
        const int Limit = 200;//최대 속도
        int Per_Booster_Gauge = 0;//개인 부스터 게이지
        int Per_Booster_Count = 0;//개인 부스터 개수
        int Team_Booster_Gauge = 0;//팀 부스터 게이지
        int Team_Booster_Count = 0;//팀 부스터 개수
        bool[] All_Booster = new bool[2];//부스터 배열(0 : 개인부스터, 1 : 팀부스터)
        int All_Booster_Count = 0;//부스터 개수
        public void Speed_Up(int n)//속도 상승
        {
            if (Limit >= Speed + n)
            {
                Speed += n;
            }
            else
            {
                Speed = Limit;
            }
        }
        public void Speed_Down(int n)//속도 하강(0보다 작아질 수 없음)
        {
            if (Speed - n > 0)
            {
                Speed -= n;
            }
            else
            {
                Speed = 0;
            }
        }
        public void Drift(int n)//드리프트(팀부, 개인부 게이지 상승 계산)
        {
            Per_Booster_Gauge += (2 * n);//드리프트 한 시간 *2만큼 게이지 상승
            Team_Booster_Gauge += (3 * n);//드리프트 한 시간*3만큼 게이지 상승
            if (Per_Booster_Gauge >= 100)//개인 부스터 게이지가 100이상일 때 개인부스터, 전체 부스터 수 증가   게이지 초기화
            {
                if (All_Booster_Count < 2)
                {
                    Per_Booster_Count++;
                    All_Booster[All_Booster_Count] = false;
                    All_Booster_Count++;
                    Per_Booster_Gauge = 0;
                }
            }
            if (Team_Booster_Gauge >= 100)//팀 부스터 게이지가 100이상일 떄 개인부스터 팀부스터로 변환, 개인부스터 개수 = 0, 게이지 초기화
            {
                if (Per_Booster_Count > 0)
                {
                    Team_Booster_Count += Per_Booster_Count;
                    Console.WriteLine("개인부스터" + Per_Booster_Count + "개인부스터가 팀부스터로 변환됩니다.");
                    Per_Booster_Count = 0;
                    Team_Booster_Gauge = 0;
                    for(int i = 0; i < All_Booster_Count; i++)
                    {
                        All_Booster[i] = true;
                    }
                }
            }
            Console.WriteLine("개인 부스터 게이지 : "+Per_Booster_Gauge+"\n팀 부스터 게이지 : "+Team_Booster_Gauge);
        }
        public void Use_Booster(int n)//n = 사용할 부스터 개수
        {
            if (All_Booster_Count >= n)
            {
                for(int i = 0; i < n; i++)
                {
                    if (All_Booster[i] == false)
                    {
                        Console.WriteLine("속도가 잠깐증가합니다.(Per Booster)");
                        Speed += 20;
                        Print_Speed();
                        Speed -= 20;
                    }
                    else if (All_Booster[i] == true)
                    {
                        Console.WriteLine("속도가 잠깐 증가합니다.(Team Booster)");
                        Speed += 30;
                        Print_Speed();
                        Speed -= 30;
                    }
                }
            }
            else
            {
                Console.WriteLine("부스터 개수가 모자랍니다.");
            }
        }
        public void Booster_Num()
        {
            Console.WriteLine("개인 부스터 : " + Per_Booster_Count + "\n팀 부스터 : " + Team_Booster_Count);
        }
        public void Print_Speed()
        {
            Console.WriteLine("현재 속도는 " + Speed + "km/h입니다.");
        }

    }
    class Program
    {
        static void Main(string[] args)
        {
            Cart Cart_1 = new Cart();
            Cart_1.Drift(20);
            Cart_1.Speed_Up(200);
            Cart_1.Use_Booster(1);
            Cart_1.Print_Speed();
            Cart_1.Booster_Num();
            Cart_1.Drift(50);
            Cart_1.Booster_Num();
            Cart_1.Speed_Down(50);
            Cart_1.Use_Booster(1);

        }
    }
}