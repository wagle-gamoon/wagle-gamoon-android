package com.codelap.waglegamoon.data.local

import com.codelap.waglegamoon.domain.model.PostStudyRecruit

object Datasource {
    fun getPostStudyList(): List<PostStudyRecruit> {
        val items = mutableListOf<PostStudyRecruit>()
        items.add(PostStudyRecruit(1, "모집중", "코틀린", "성남", "개발 스터디 구합니다", "오늘 15:30", "Tnalxmsk"))
        items.add(PostStudyRecruit(2,"모집중", "자바", "분당", "자바 스터디 구해요", "오늘 16:30", "자고싶다") )
        items.add(PostStudyRecruit(3,"모집중", "토익", "서울", "토익 스터디 구해요", "오늘 17:30", "너무 피곤하다") )
        items.add(PostStudyRecruit(4,"모집중", "한국사", "성남", "한국사 하실분", "오늘 18:30", "T살려줘") )
        items.add(PostStudyRecruit(5, "모집중", "취업", "성남", "대기업 취준생 스터디 구합니다", "오늘 19:20", "너무 피곤해") )
        items.add(PostStudyRecruit( 6,"모집중", "영어", "서울", "토익, 토스 준비 같이해요", "오늘 19:33", "무의식적으로") )
        items.add(PostStudyRecruit(7, "모집중", "학점준비", "서울", "과탑하자", "오늘 19:40", "타자를 치고 있네") )
        items.add(PostStudyRecruit(8, "모집중", "CPA", "서울", "CPA 준비하는 사람?", "오늘 20:30", "하하") )
        return items
    }
}