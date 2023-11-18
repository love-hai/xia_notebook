package com.xhf.test.service;

import com.xhf.test.model.NoteEventSubjectParam;
import lombok.extern.slf4j.Slf4j;

/**
 * @projectName: test
 * @package: com.xhf.test.service
 * @className: mainTest
 * @descriptions:
 * @author: xiahaifeng
 * @createDate: 2023/9/21 14:20
 * @updateUser: xiahaifeng
 * @updateDate: 2023/9/21 14:20
 * @updateRemark:
 */
@Slf4j
public class mainTest {

    public static void main(String[] args) {
        NoteEventSubjectParam noteEventSubjectParam = new NoteEventSubjectParam();
        noteEventSubjectParam.setNoteEventSubjectType((byte) 1);
        noteEventSubjectParam.setPlatFromCode("platFromCode");
        noteEventSubjectParam.getNoteEventSubject().add("noteEventSubject");
        System.out.println(noteEventSubjectParam.toString());

        NoteEventSubjectParam noteEventSubjectParam1 = new NoteEventSubjectParam(noteEventSubjectParam.toString());
        System.out.println(noteEventSubjectParam1.getNoteEventSubjectType());
        System.out.println(noteEventSubjectParam1.getPlatFromCode());
        System.out.println(noteEventSubjectParam1.getNoteEventSubject());
    }
}
