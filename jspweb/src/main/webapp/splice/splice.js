console.log('splicejs 실행');

var wavesurfer = WaveSurfer.create({
    // id="waveform" 인 오브젝트에 파형 생성
    // 필수 옵션
    container: '#waveform',
    // 선택 옵션들 
    waveColor: 'violet',
    progressColor: 'purple'
});

wavesurfer.load('audio.wav');
