fun main() {
    val firstTeacher = setOf("Матигоров Никита Иванович", "Тестов Тест Тестович", "Иванов Иван Иваныч")
    val secondTeacher = setOf("Матигоров Иван Иванович", "Тестов Тест Тестович", "Михалков Иван Иваныч")

    val unionStudents = firstTeacher.union(secondTeacher)
    print("${unionStudents.size} студентов всего отправлено на пересдачу: ")
    println(unionStudents)

    val intersectStudents = firstTeacher.intersect(secondTeacher)
    print("${intersectStudents.size} студентов не сдали оба зачёта: ")
    println(intersectStudents)

    print("${unionStudents.size - intersectStudents.size} студентов не сдали только один зачёт: ")
    println(unionStudents - intersectStudents)
}
